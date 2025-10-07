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

package com.apitable.interfaces.billing.model;

import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.AdminNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.ApiCallNumsPerMonth;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.ApiQpsNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.ArchivedRowsPerSheet;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.AutomationRunNumsPerMonth;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.CalendarViewNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.CapacitySize;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.FieldPermissionNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.FileNodeNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.FormNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.GanttViewNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.MirrorNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.NodePermissionNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.RowsPerSheet;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.Seat;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.TotalRows;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.WidgetNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.SolidFeatures.AuditQueryDays;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.SolidFeatures.RemainRecordActivityDays;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.SolidFeatures.RemainTimeMachineDays;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.SolidFeatures.RemainTrashDays;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.SubscribeFeatures.AllowApplyJoin;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.SubscribeFeatures.AllowCopyData;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.SubscribeFeatures.AllowDownload;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.SubscribeFeatures.AllowEmbed;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.SubscribeFeatures.AllowExport;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.SubscribeFeatures.AllowInvitation;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.SubscribeFeatures.AllowOrgApi;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.SubscribeFeatures.AllowShare;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.SubscribeFeatures.ContactIsolation;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.SubscribeFeatures.ControlFormBrandLogo;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.SubscribeFeatures.ForbidCreateOnCatalog;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.SubscribeFeatures.RainbowLabel;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.SubscribeFeatures.ShowMobileNumber;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.SubscribeFeatures.SocialConnect;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.SubscribeFeatures.Watermark;

/**
 * Default subscription feature.
 */
public class DefaultSubscriptionFeature implements SubscriptionFeature {

    @Override
    public Seat getSeat() {
        return new Seat(5L); // 5 seats for free users
    }

    @Override
    public CapacitySize getCapacitySize() {
        return new CapacitySize(1024 * 1024 * 1024L); // 1GB for free users
    }

    @Override
    public FileNodeNums getFileNodeNums() {
        return new FileNodeNums(30L); // 30 file nodes for free users
    }

    @Override
    public RowsPerSheet getRowsPerSheet() {
        return new RowsPerSheet(100L); // 100 rows per sheet for free users
    }

    @Override
    public ArchivedRowsPerSheet getArchivedRowsPerSheet() {
        return new ArchivedRowsPerSheet(250L);
    }

    @Override
    public TotalRows getTotalRows() {
        return new TotalRows(20000L); // 20,000 rows for free users
    }

    @Override
    public MirrorNums getMirrorNums() {
        return new MirrorNums(5L); // 5 mirrors for free users
    }

    @Override
    public AdminNums getAdminNums() {
        return new AdminNums(3L); // 3 admins for free users
    }

    @Override
    public ApiCallNumsPerMonth getApiCallNumsPerMonth() {
        return new ApiCallNumsPerMonth(10000L); // 10,000 API calls per month for free users
    }


    @Override
    public WidgetNums getWidgetNums() {
        return new WidgetNums(30L); // 30 widgets for free users
    }

    @Override
    public AutomationRunNumsPerMonth getAutomationRunNumsPerMonth() {
        return new AutomationRunNumsPerMonth(100L); // 100 automation runs per month for free users
    }

    @Override
    public FormNums getFormNums() {
        return new FormNums(20L); // 20 forms for free users
    }

    @Override
    public GanttViewNums getGanttViewNums() {
        return new GanttViewNums(10L); // 10 Gantt views for free users
    }

    @Override
    public CalendarViewNums getCalendarViewNums() {
        return new CalendarViewNums(5L); // 5 calendar views for free users
    }

    @Override
    public FieldPermissionNums getFieldPermissionNums() {
        return new FieldPermissionNums(10L); // 10 field permissions for free users
    }

    @Override
    public NodePermissionNums getNodePermissionNums() {
        return new NodePermissionNums(10L); // 10 node permissions for free users
    }

    @Override
    public ApiQpsNums getApiQpsNums() {
        return new ApiQpsNums(5L);
    }

    @Override
    public SocialConnect getSocialConnect() {
        return new SocialConnect(false);
    }

    @Override
    public RainbowLabel getRainbowLabel() {
        return new RainbowLabel(false);
    }

    @Override
    public Watermark getWatermark() {
        return new Watermark(false);
    }

    @Override
    public AllowInvitation getAllowInvitation() {
        return new AllowInvitation(false);
    }

    @Override
    public AllowApplyJoin getAllowApplyJoin() {
        return new AllowApplyJoin(false);
    }

    @Override
    public AllowShare getAllowShare() {
        return new AllowShare(false);
    }

    @Override
    public AllowExport getAllowExport() {
        return new AllowExport(false);
    }

    @Override
    public AllowDownload getAllowDownload() {
        return new AllowDownload(false);
    }

    @Override
    public AllowCopyData getAllowCopyData() {
        return new AllowCopyData(false);
    }

    @Override
    public AllowEmbed getAllowEmbed() {
        return new AllowEmbed(false);
    }

    @Override
    public ControlFormBrandLogo getControlFormBrandLogo() {
        return new ControlFormBrandLogo(false);
    }

    @Override
    public ShowMobileNumber getShowMobileNumber() {
        return new ShowMobileNumber(false);
    }

    @Override
    public ContactIsolation getContactIsolation() {
        return new ContactIsolation(false);
    }

    @Override
    public ForbidCreateOnCatalog getForbidCreateOnCatalog() {
        return new ForbidCreateOnCatalog(false);
    }

    @Override
    public RemainTrashDays getRemainTrashDays() {
        return new RemainTrashDays(-1L);
    }

    @Override
    public RemainTimeMachineDays getRemainTimeMachineDays() {
        return new RemainTimeMachineDays(-1L);
    }

    @Override
    public RemainRecordActivityDays getRemainRecordActivityDays() {
        return new RemainRecordActivityDays(-1L);
    }

    @Override
    public AuditQueryDays getAuditQueryDays() {
        return new AuditQueryDays(0L);
    }

    @Override
    public AllowOrgApi getAllowOrgApi() {
        return new AllowOrgApi(false);
    }
}
