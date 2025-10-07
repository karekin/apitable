/*
 * APITable <https://github.com/apitable/apitable>
 * Copyright (C) 2022 APITable Ltd. <https://apitable.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.apitable.interfaces.billing.facade;

import com.apitable.interfaces.billing.model.PaidSubscriptionInfo;
import com.apitable.interfaces.billing.model.SubscriptionInfo;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for DefaultEntitlementServiceFacadeImpl.
 */
class DefaultEntitlementServiceFacadeImplTest {

    @Test
    void testGetSpaceSubscriptionWithDefaultSubscription() {
        DefaultEntitlementServiceFacadeImpl facade = new DefaultEntitlementServiceFacadeImpl();
        ReflectionTestUtils.setField(facade, "usePaidSubscription", false);
        
        SubscriptionInfo subscriptionInfo = facade.getSpaceSubscription("test-space-id");
        
        assertNotNull(subscriptionInfo);
        assertTrue(subscriptionInfo.isFree());
        assertEquals(2L, subscriptionInfo.getFeature().getSeat().getValue());
    }

    @Test
    void testGetSpaceSubscriptionWithPaidSubscription() {
        DefaultEntitlementServiceFacadeImpl facade = new DefaultEntitlementServiceFacadeImpl();
        ReflectionTestUtils.setField(facade, "usePaidSubscription", true);
        
        SubscriptionInfo subscriptionInfo = facade.getSpaceSubscription("test-space-id");
        
        assertNotNull(subscriptionInfo);
        assertFalse(subscriptionInfo.isFree());
        assertTrue(subscriptionInfo instanceof PaidSubscriptionInfo);
        assertEquals(-1L, subscriptionInfo.getFeature().getSeat().getValue()); // unlimited
    }
}
