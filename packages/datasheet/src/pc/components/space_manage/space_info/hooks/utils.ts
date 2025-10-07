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

export const calcPercent = (used: number | undefined, total: number | string | null | undefined) => {
  // 处理无限制情况
  if (!used || !total || total === -1 || total === "unlimited" || total === null || total === undefined) {
    return 0;
  }
  return Math.min(Math.ceil((used / total) * 100), 100);
};

// 处理无限制情况，将 "unlimited" 字符串、null/undefined 转换为 -1
export const processTotal = (total: number | string | null | undefined) => {
  if (total === "unlimited" || total === null || total === undefined) {
    return -1;
  }
  return Number(total);
};
