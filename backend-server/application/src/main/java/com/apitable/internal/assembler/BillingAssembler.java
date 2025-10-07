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

package com.apitable.internal.assembler;

import com.apitable.interfaces.billing.model.SubscriptionFeature;
import com.apitable.interfaces.billing.model.SubscriptionInfo;
import com.apitable.internal.vo.InternalSpaceApiRateLimitVo;
import com.apitable.internal.vo.InternalSpaceApiUsageVo;
import com.apitable.internal.vo.InternalSpaceSubscriptionVo;

/**
 * Billing Assembler.
 *
 * @author Shawn Deng
 */
public class BillingAssembler {

    /**
     * convert SubscriptionInfo to InternalSpaceSubscriptionVo.
     *
     * @param subscriptionInfo subscription info
     * @return InternalSpaceSubscriptionVo
     */
    public InternalSpaceSubscriptionVo toVo(SubscriptionInfo subscriptionInfo) {
        SubscriptionFeature billingPlanFeature = subscriptionInfo.getFeature();
        InternalSpaceSubscriptionVo subscriptionVo = new InternalSpaceSubscriptionVo();
        
        // Handle unlimited values (-1) by setting to null
        Long calendarViews = billingPlanFeature.getCalendarViewNums().getValue();
        subscriptionVo.setMaxCalendarViewsInSpace(calendarViews < 0 ? null : calendarViews);
        
        Long galleryViews = billingPlanFeature.getGalleryViewNums().getValue();
        subscriptionVo.setMaxGalleryViewsInSpace(galleryViews < 0 ? null : galleryViews);
        
        Long ganttViews = billingPlanFeature.getGanttViewNums().getValue();
        subscriptionVo.setMaxGanttViewsInSpace(ganttViews < 0 ? null : ganttViews);
        
        Long kanbanViews = billingPlanFeature.getKanbanViewNums().getValue();
        subscriptionVo.setMaxKanbanViewsInSpace(kanbanViews < 0 ? null : kanbanViews);
        
        Long totalRows = billingPlanFeature.getTotalRows().getValue();
        subscriptionVo.setMaxRowsInSpace(totalRows < 0 ? null : totalRows);
        
        Long rowsPerSheet = billingPlanFeature.getRowsPerSheet().getValue();
        subscriptionVo.setMaxRowsPerSheet(rowsPerSheet < 0 ? null : rowsPerSheet);
        
        Long archivedRows = billingPlanFeature.getArchivedRowsPerSheet().getValue();
        subscriptionVo.setMaxArchivedRowsPerSheet(archivedRows < 0 ? null : archivedRows);
        
        Long messageCredits = billingPlanFeature.getMessageCreditNums().getValue();
        subscriptionVo.setMaxMessageCredits(messageCredits < 0 ? null : messageCredits);
        
        Long widgetNums = billingPlanFeature.getWidgetNums().getValue();
        subscriptionVo.setMaxWidgetNums(widgetNums < 0 ? null : widgetNums);
        
        Long automationRuns = billingPlanFeature.getAutomationRunNumsPerMonth().getValue();
        subscriptionVo.setMaxAutomationRunsNums(automationRuns < 0 ? null : automationRuns);
        
        subscriptionVo.setAllowEmbed(billingPlanFeature.getAllowEmbed().getValue());
        subscriptionVo.setAllowOrgApi(billingPlanFeature.getAllowOrgApi().getValue());
        return subscriptionVo;
    }

    /**
     * convert SubscriptionFeature to InternalSpaceCapacityVo.
     *
     * @param planFeature billing plan feature
     * @return InternalSpaceCapacityVo
     */
    public InternalSpaceApiUsageVo toApiUsageVo(SubscriptionFeature planFeature) {
        InternalSpaceApiUsageVo vo = new InternalSpaceApiUsageVo();
        
        // Handle unlimited values (-1) by setting to null
        Long apiCallNums = planFeature.getApiCallNumsPerMonth().getValue();
        vo.setMaxApiUsageCount(apiCallNums < 0 ? null : apiCallNums);
        vo.setApiCallNumsPerMonth(apiCallNums < 0 ? null : apiCallNums);
        vo.setIsAllowOverLimit(true);
        return vo;
    }

    /**
     * convert SubscriptionFeature to InternalSpaceCapacityVo.
     *
     * @param planFeature billing plan feature
     * @return InternalSpaceCapacityVo
     */
    public InternalSpaceApiRateLimitVo toApiRateLimitVo(SubscriptionFeature planFeature) {
        InternalSpaceApiRateLimitVo vo = new InternalSpaceApiRateLimitVo();
        
        // Handle unlimited values (-1) by setting to null
        Long qps = planFeature.getApiQpsNums().getValue();
        vo.setQps(qps < 0 ? null : qps);
        return vo;
    }
}
