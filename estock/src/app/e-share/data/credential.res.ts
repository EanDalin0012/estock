import { DataConstant } from './constant.data';
export interface ResCredential extends DataConstant {
  accountExpired: boolean;
  accountLocked: boolean;
  credentialsExpired: boolean;
  dateTime: string;
  enabled: boolean;
  id: number;
  userName: string;
}
