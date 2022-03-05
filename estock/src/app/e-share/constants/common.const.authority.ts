import { AuthorizationServer } from './../data/authorization.server';
export const AuthorizationServerDataConstant: AuthorizationServer[] = [
  {
    url: '/sale',
    authorizationCode: 'SALE'
  },
  {
    url: '/user',
    authorizationCode: 'READ_USER'
  },
  {
    url: '/user/add',
    authorizationCode: 'ADD_USER'
  },
  {
    url: '/user/edit',
    authorizationCode: 'EDIT_USER'
  },
  {
    url: '/user/role',
    authorizationCode: 'READ_ROLE'
  },
  {
    url: '/user/role/add',
    authorizationCode: 'ADD_ROLE'
  },
  {
    url: '/user/role/edit',
    authorizationCode: 'EDIT_ROLE'
  }
];
