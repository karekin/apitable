/**
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

import { useMemo } from 'react';
import { useThemeColors } from '@apitable/components';
import { Strings, t } from '@apitable/core';
import { GanttOutlined, CalendarOutlined, FormOutlined, MirrorOutlined } from '@apitable/icons';
import { IHooksParams, IMultiLineItemProps } from '../interface';
import { calcPercent, processTotal } from './utils';

export const useView = ({ spaceInfo, subscription }: IHooksParams): IMultiLineItemProps[] => {
  const colors = useThemeColors();
  return useMemo(() => {
    // 优先使用 spaceInfo 中的新字段，支持无限制显示
    const maxGanttViews = spaceInfo?.maxGanttViewsInSpace || subscription?.maxGanttViewsInSpace;
    const maxCalendarViews = spaceInfo?.maxCalendarViewsInSpace || subscription?.maxCalendarViewsInSpace;
    const maxFormViews = spaceInfo?.maxFormViewsInSpace || subscription?.maxFormViewsInSpace;
    const maxMirrorNums = spaceInfo?.maxMirrorNums || subscription?.maxMirrorNums;
    
    
    return [
      {
        unit: t(Strings.unit_piece),
        total: processTotal(maxGanttViews),
        used: spaceInfo?.ganttViewNums,
        name: t(Strings.gantt_view),
        icon: <GanttOutlined color={colors.black[500]} />,
        percent: calcPercent(spaceInfo?.ganttViewNums, maxGanttViews),
        showProgress: true,
      },
      {
        unit: t(Strings.unit_piece),
        total: processTotal(maxCalendarViews),
        used: spaceInfo?.calendarViewNums,
        name: t(Strings.calendar_view),
        icon: <CalendarOutlined color={colors.black[500]} />,
        percent: calcPercent(spaceInfo?.calendarViewNums, maxCalendarViews),
        showProgress: true,
      },
      {
        unit: t(Strings.unit_piece),
        total: processTotal(maxFormViews),
        used: spaceInfo?.formViewNums,
        name: t(Strings.view_form),
        icon: <FormOutlined color={colors.black[500]} />,
        percent: calcPercent(spaceInfo?.formViewNums, maxFormViews),
        showProgress: true,
      },
      {
        unit: t(Strings.unit_piece),
        total: processTotal(maxMirrorNums),
        used: spaceInfo?.mirrorNums,
        name: t(Strings.mirror),
        icon: <MirrorOutlined color={colors.black[500]} />,
        percent: calcPercent(spaceInfo?.mirrorNums, maxMirrorNums),
        showProgress: true,
      },
    ];
  }, [subscription, spaceInfo, colors]);
};
