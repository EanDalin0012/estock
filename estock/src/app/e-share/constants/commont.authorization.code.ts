import { AuthorizationCode } from './../data/authorization';
export const AuthorizationCodeDataConstant: AuthorizationCode[] = [
  // User Authorization Code
  {
    id: 1,
    authorizationCode: 'READ_USER'
  },
  {
    id: 2,
    authorizationCode: 'ADD_USER'
  },
  {
    id: 3,
    authorizationCode: 'EDIT_USER'
  },
  {
    id: 4,
    authorizationCode: 'DELETE_USER'
  },  {
    id: 5,
    authorizationCode: 'EXPORT_USER'
  }
   // User Role Authorzation Code
  , {
    id: 6,
    authorizationCode: 'READ_ROLE'
  }, {
    id: 7,
    authorizationCode: 'ADD_ROLE'
  }, {
    id: 8,
    authorizationCode: 'EDIT_ROLE'
  }, {
    id: 9,
    authorizationCode: 'DELETE_ROLE'
  },
];
