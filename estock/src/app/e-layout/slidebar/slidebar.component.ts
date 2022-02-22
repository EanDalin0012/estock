import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import * as $ from 'jquery';
import {DataService} from "../../e-share/service/data.service";

@Component({
  selector: 'app-slidebar',
  templateUrl: './slidebar.component.html',
  styleUrls: ['./slidebar.component.css']
})
export class SlidebarComponent implements OnInit {

  accountInfo = {
    id: 0,
    accountID: '',
    accountName: '',
    accountBalance: 0,
    accountType: '',
    status:'',
    currency: ''
  };

  urlComplete = {
    mainUrl: '',
    childUrl: '',
    subUrl: ''
  };

  sidebarMenus = {
    default: true,
    chat: false,
    settings: false,
  };

  members:any = {
    active: '',
    total: []
  };
  groups: any;
  accountType ='';

  menueAccessLstMovie = false;
  menueAccessClientSetting = false;
  menueAccessMovieTypeSetting = false;
  menueAccessSubMovieTypeSetting = false;
  menueAccessUser = false;

  authorities:any[] = [];

  constructor(
    private router: Router,
    private dataService: DataService,
    // private authService: AuthService
  ) {
    // this.router.events.subscribe((event: Event) => {
    //   if (event instanceof NavigationEnd) {
    //     $(".main-wrapper").removeClass('slide-nav');
    //     $(".sidebar-overlay").removeClass('opened');
    //     const url = event.url.split("/");
    //     this.urlComplete.mainUrl = url[1];
    //     this.urlComplete.subUrl = url[2];
    //     this.urlComplete.childUrl = url[3];
    //     if (url[1] === "") {
    //       this.urlComplete.mainUrl = "dashboard";
    //       this.urlComplete.subUrl = "admin";
    //     }

    //     if (url[2] === "chat" || url[2] === "calls") {
    //       this.sidebarMenus.chat = true;
    //       this.sidebarMenus.default = false;
    //     } else {
    //       this.sidebarMenus.chat = false;
    //       this.sidebarMenus.default = true;
    //     }
    //   }
    // });

    this.groups = {
      active: "",
      total: ["general", "video responsive survey", "500rs", "warehouse"],
    };
    this.members = {
      active: "Mike Litorus",
      total: [
        { name: "John Doe", count: 3 },
        { name: "Richard Miles", count: 0 },
        { name: "John Smith", count: 7 },
        { name: "Mike Litorus", count: 9 },
      ],
    };
  }

  ngOnInit() {
    this.urlComplete.mainUrl = 'acc';
    // this.urlComplete.subUrl = AccountTypeCode.Admin;

    // Slide up and down of menus
    $(document).on("click", "#sidebar-menu a", function (e) {
      e.stopImmediatePropagation();
      if ($(this).parent().hasClass("submenu")) {
        e.preventDefault();
      }
      if (!$(this).hasClass("subdrop")) {
        $("ul", $(this).parents("ul:first")).slideUp(350);
        $("a", $(this).parents("ul:first")).removeClass("subdrop");
        $(this).next("ul").slideDown(350);
        $(this).addClass("subdrop");
      } else if ($(this).hasClass("subdrop")) {
        $(this).removeClass("subdrop");
        $(this).next("ul").slideUp(350);
      }
    });

    // this.dataService.visitData.subscribe(message => {
    //   if (message !== '') {
    //     setTimeout(() => {
    //       this.urlComplete.mainUrl = message;
    //       this.urlComplete.subUrl = message;
    //     });
    //   }
    // });

    this.dataService.visitSourceParamRoutorChangeData.subscribe(message => {
      let msg = '';
      if (message !== '') {
        msg = message;
      }
      this.activeSidebar(msg);
    });

    // this.accountInfo = Utils.getSecureStorage(LOCAL_STORAGE.Account_Info);

    // const data = Utils.getSecureStorage(LOCAL_STORAGE.USER_INFO);
    // this.authorities = data.authorities;

    // if(this.authorities.length > 0) {

    //   this.authorities.forEach(element => {

    //     if(element.id === AuthorizationModule.User_Read) {
    //       this.menueAccessUser = true;
    //     }
    //     if(element.id === AuthorizationModule.Movie_Read) {
    //       this.menueAccessLstMovie = true;
    //     }
    //     if(element.id === AuthorizationModule.Setting_Movie_Type_Read) {
    //       this.menueAccessMovieTypeSetting = true;
    //     }
    //     if(element.id === AuthorizationModule.Setting_Sub_Movie_Type_Read) {
    //       this.menueAccessSubMovieTypeSetting = true;
    //     }
    //     if(element.id === AuthorizationModule.Setting_Client_Setting_Read) {
    //       this.menueAccessClientSetting = true;
    //     }

    //   });
    // }


  }

  setActive(member:any) {
    // this.allModulesService.members.active = member;
  }

  routerAccount() {
    this.urlComplete.mainUrl = 'acc';
    this.urlComplete.subUrl = this.accountInfo.accountType;
    // this.dataService.visitParamRouterChange('acc');
    this.onNavigateRoutor('/acc/');
  }

  onNavigateRoutor(router: string) {
    this.router.navigate([router]);
  }

  activeSidebar(msg: string) {
    switch (msg) {
      case 'sale':
        this.urlComplete.mainUrl = 'sale';
        this.urlComplete.subUrl = 'sale';
        break;
      case 'stock':
        this.urlComplete.mainUrl = 'stock';
        this.urlComplete.subUrl = 'stock';
        break;
      case 'warehouse':
        this.urlComplete.mainUrl = 'warehouse';
        this.urlComplete.subUrl = 'warehouse';
        break;
      case 'product':
        this.urlComplete.mainUrl = 'product';
        this.urlComplete.subUrl = 'product';
        break;
      case 'product-import':
        this.urlComplete.mainUrl = 'product';
        this.urlComplete.subUrl = 'product-import';
        break;



      case 'user':
        this.urlComplete.mainUrl = msg;
        this.urlComplete.subUrl = msg;
        break;
      case 'role':
        this.urlComplete.mainUrl = 'user'
        this.urlComplete.subUrl = 'role';
        break;


      case 'seting-sub-movie-type':
        this.urlComplete.mainUrl = 'setting';
        this.urlComplete.subUrl = 'seting-sub-movie-type';
        break;
      case 'seting-sub-movie-type-add':
        this.urlComplete.mainUrl = 'setting';
        this.urlComplete.subUrl = 'seting-sub-movie-type-add';
        break;
      case 'seting-sub-movie-type-edit':
        this.urlComplete.mainUrl = 'setting';
        this.urlComplete.subUrl = 'seting-sub-movie-type-edit';
        break;

      case 'seting-movie-type':
        this.urlComplete.mainUrl = 'setting';
        this.urlComplete.subUrl = 'seting-movie-type';
        break;
      case 'seting-movie-type-add':
        this.urlComplete.mainUrl = 'setting';
        this.urlComplete.subUrl = 'seting-movie-type-add';
        break;
      case 'seting-movie-type-edit':
        this.urlComplete.mainUrl = 'setting';
        this.urlComplete.subUrl = 'seting-movie-type-edit';
        break;

      case 'seting-client-vd':
        this.urlComplete.mainUrl = 'setting';
        this.urlComplete.subUrl = 'seting-client-vd';
        break;
      case 'seting-movie-add':
        this.urlComplete.mainUrl = 'setting';
        this.urlComplete.subUrl = 'seting-movie-add';
        break;
      case 'seting-movie-edit':
        this.urlComplete.mainUrl = 'setting';
        this.urlComplete.subUrl = 'seting-movie-edit';
        break;
      case 'home':
        this.urlComplete.mainUrl = 'home';
        this.urlComplete.subUrl = 'home';
        break;
      case 'vd-add':
          this.urlComplete.mainUrl = 'home';
          this.urlComplete.subUrl = 'vd-add';
          break;
      case 'vd-edit':
        this.urlComplete.mainUrl = 'home';
        this.urlComplete.subUrl = 'vd-edit';
        break;
      case 'account':
        this.urlComplete.mainUrl = 'account';
        this.urlComplete.subUrl = 'account';
        break;
      case 'user-add':
        this.urlComplete.mainUrl = 'account';
        this.urlComplete.subUrl = 'user-add';
        break;
      case 'user-edit':
        this.urlComplete.mainUrl = 'account';
        this.urlComplete.subUrl = 'user-edit';
        break;

      default:
        this.urlComplete.mainUrl = '';
        this.urlComplete.subUrl = msg;
        break;
    }

  }

  btnSale(){
    this.router.navigate(['/sale']);
  }

  btnRouting(routure: string) {
    this.router.navigate([routure]);
  }

}
