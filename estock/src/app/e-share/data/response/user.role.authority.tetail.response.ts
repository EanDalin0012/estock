import { Authority } from '../authority';
import { DataConstant } from '../constant.data';

export interface UserRoleAuthorityDetailResponse extends DataConstant {
  id:number;
  role: string;
  desc: string;
  authorities: Authority[];
}
