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
import { decimalCeil } from '@apitable/core';
import { IHooksParams, IHooksResult } from '../interface';
import { getPercent } from '../utils';

export const useApi = ({ subscription, spaceInfo }: IHooksParams): IHooksResult => {
  const { used, total } = useMemo(() => {
    // 优先使用新的字段，支持无限制显示
    const maxApiCalls = spaceInfo?.maxApiCallsPerMonth || spaceInfo?.maxApiRequestCount || subscription?.maxApiCall || 0;
    return {
      used: spaceInfo?.apiRequestCountUsage || 0,
      total: maxApiCalls,
    };
  }, [subscription, spaceInfo]);
  return useMemo(() => {
    // 处理无限制情况
    const isUnlimited = total === 'unlimited' || total === null || total === undefined;
    const numericTotal = isUnlimited ? -1 : Number(total);
    const remain = isUnlimited ? -1 : Math.max(0, numericTotal - used);
    const usedText = used.toLocaleString();
    const totalText = isUnlimited ? 'unlimited' : numericTotal.toLocaleString();
    const usedPercent = isUnlimited ? 0 : decimalCeil(getPercent(used / numericTotal) * 100);
    const remainText = isUnlimited ? 'unlimited' : remain.toLocaleString();
    const remainPercent = isUnlimited ? 0 : Math.max(0, 100 - usedPercent);
    return {
      used,
      usedText,
      total: numericTotal,
      totalText,
      remain,
      usedPercent,
      remainPercent,
      remainText,
    };
  }, [used, total]);
};
