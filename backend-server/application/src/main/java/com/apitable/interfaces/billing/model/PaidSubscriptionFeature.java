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
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.AiAgentNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.ApiCallNumsPerMonth;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.ApiQpsNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.ArchivedRowsPerSheet;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.CalendarViewNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.CapacitySize;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.FieldPermissionNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.FileNodeNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.FormNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.GanttViewNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.KanbanViewNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.MessageCreditNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.MirrorNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.NodePermissionNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.RowsPerSheet;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.Seat;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.TotalRows;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.WidgetNums;
import com.apitable.interfaces.billing.model.SubscriptionFeatures.ConsumeFeatures.AutomationRunNumsPerMonth;
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
 * Paid subscription feature with unlimited seats.
 */
public class PaidSubscriptionFeature implements SubscriptionFeature {

    @Override
    public Seat getSeat() {
        return new Seat(-1L); // -1 means unlimited
    }

    @Override
    public CapacitySize getCapacitySize() {
        return new CapacitySize(1024 * 1024 * 1024 * 100L); // 100GB
    }

    @Override
    public FileNodeNums getFileNodeNums() {
        return new FileNodeNums(-1L); // unlimited
    }

    @Override
    public RowsPerSheet getRowsPerSheet() {
        return new RowsPerSheet(-1L); // unlimited
    }

    @Override
    public ArchivedRowsPerSheet getArchivedRowsPerSheet() {
        return new ArchivedRowsPerSheet(-1L); // unlimited
    }

    @Override
    public TotalRows getTotalRows() {
        return new TotalRows(-1L); // unlimited
    }

    @Override
    public MirrorNums getMirrorNums() {
        return new MirrorNums(-1L); // unlimited
    }

    @Override
    public AdminNums getAdminNums() {
        return new AdminNums(-1L); // unlimited
    }

    @Override
    public ApiCallNumsPerMonth getApiCallNumsPerMonth() {
        return new ApiCallNumsPerMonth(-1L); // unlimited
    }

    @Override
    public WidgetNums getWidgetNums() {
        return new WidgetNums(-1L); // unlimited
    }

    @Override
    public AutomationRunNumsPerMonth getAutomationRunNumsPerMonth() {
        return new AutomationRunNumsPerMonth(-1L); // unlimited
    }

    @Override
    public FormNums getFormNums() {
        return new FormNums(-1L); // unlimited
    }

    @Override
    public GanttViewNums getGanttViewNums() {
        return new GanttViewNums(-1L); // unlimited
    }

    @Override
    public CalendarViewNums getCalendarViewNums() {
        return new CalendarViewNums(-1L); // unlimited
    }

    @Override
    public KanbanViewNums getKanbanViewNums() {
        return new KanbanViewNums(-1L); // unlimited
    }

    @Override
    public MessageCreditNums getMessageCreditNums() {
        return new MessageCreditNums(-1L); // unlimited
    }

    @Override
    public AiAgentNums getAiAgentNums() {
        return new AiAgentNums(-1L); // unlimited
    }

    @Override
    public ContactIsolation getContactIsolation() {
        return new ContactIsolation(true);
    }

    @Override
    public ControlFormBrandLogo getControlFormBrandLogo() {
        return new ControlFormBrandLogo(true);
    }

    @Override
    public ForbidCreateOnCatalog getForbidCreateOnCatalog() {
        return new ForbidCreateOnCatalog(false);
    }

    @Override
    public RainbowLabel getRainbowLabel() {
        return new RainbowLabel(true);
    }

    @Override
    public ShowMobileNumber getShowMobileNumber() {
        return new ShowMobileNumber(true);
    }

    @Override
    public SocialConnect getSocialConnect() {
        return new SocialConnect(true);
    }

    @Override
    public Watermark getWatermark() {
        return new Watermark(false);
    }

    @Override
    public FieldPermissionNums getFieldPermissionNums() {
        return new FieldPermissionNums(-1L); // unlimited
    }

    @Override
    public NodePermissionNums getNodePermissionNums() {
        return new NodePermissionNums(-1L); // unlimited
    }

    @Override
    public ApiQpsNums getApiQpsNums() {
        return new ApiQpsNums(-1L); // unlimited
    }

    @Override
    public AllowInvitation getAllowInvitation() {
        return new AllowInvitation(true);
    }

    @Override
    public AllowApplyJoin getAllowApplyJoin() {
        return new AllowApplyJoin(true);
    }

    @Override
    public AllowShare getAllowShare() {
        return new AllowShare(true);
    }

    @Override
    public AllowExport getAllowExport() {
        return new AllowExport(true);
    }

    @Override
    public AllowDownload getAllowDownload() {
        return new AllowDownload(true);
    }

    @Override
    public AllowCopyData getAllowCopyData() {
        return new AllowCopyData(true);
    }

    @Override
    public AllowEmbed getAllowEmbed() {
        return new AllowEmbed(true);
    }

    @Override
    public RemainTrashDays getRemainTrashDays() {
        return new RemainTrashDays(30L);
    }

    @Override
    public RemainTimeMachineDays getRemainTimeMachineDays() {
        return new RemainTimeMachineDays(30L);
    }

    @Override
    public RemainRecordActivityDays getRemainRecordActivityDays() {
        return new RemainRecordActivityDays(30L);
    }

    /**
     * @deprecated This method is deprecated since version 1.7.0 and will be removed in a future version.
     */
    @Override
    @Deprecated(since = "1.7.0", forRemoval = true)
    public AuditQueryDays getAuditQueryDays() {
        return new AuditQueryDays(30L);
    }

    @Override
    public AllowOrgApi getAllowOrgApi() {
        return new AllowOrgApi(true);
    }
}
