import { Role } from 'src/app/e-share/data/role';
import { UserInfo } from 'src/app/e-share/data/user-inf';
import { ResCredential } from '../credential.res';
import { Authority } from '../authority';

export interface LoadUserInfoResponse {
  credential: ResCredential;
  authorities: Authority[];
  userInfo: UserInfo;
  userRole: Role;
}
