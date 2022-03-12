import { Role } from './../role';
import { ResCredential } from './../credential.res';
import { DataConstant } from './../constant.data';
export interface UserInfoDetailsResponse extends DataConstant {
  id: number;
  firstName: string;
  lastName: string;
  gender: string;
  dateBirth: string;
  phone: string;
  desc: string;
  resourceID: number;
  credentials: ResCredential[];
  userRole: Role;
}

export interface UserInfoDetailsDisplay extends  UserInfoDetailsResponse{
  userNameDisplay: string;
}

