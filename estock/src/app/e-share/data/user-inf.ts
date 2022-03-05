import { DataConstant } from './constant.data';
export interface UserInfo extends DataConstant{
  id:number;
  firstName: string;
  lastName: string;
  gender: string;
  dateBirth: string;
  phone: string;
  desc: string;
  resourceID: number;
}
