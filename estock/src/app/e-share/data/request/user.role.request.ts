export interface UserRoleRequest {
  id: number;
  role: string;
  desc: string;
  authorities: number[];
}
