import { DataConstant } from './constant.data';
export interface Role  extends DataConstant{
  id: number;
  role: string;
  desc: string;
}
