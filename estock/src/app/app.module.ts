import { ELayoutComponent } from './e-layout/e-layout.component';
import { ELayoutModule } from './e-layout/e-layout.module';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EShareModule } from './e-share/e-share.module';
import { BlanklayoutComponent } from './e-layout/blanklayout/blanklayout.component';
import { ToastrModule } from 'ngx-toastr';
// import { AuthInterceptor } from './e-share/service/auth-interceptor.service';
import { Error404Component } from './error/error404/error404.component';
import { Error405Component } from './error/error405/error405.component';
import { Error403Component } from './error/error403/error403.component';


export function createTranslateLoader(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

@NgModule({
  declarations: [
    AppComponent,
    ELayoutComponent,
    BlanklayoutComponent,
    Error404Component,
    Error405Component,
    Error403Component,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ELayoutModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: (createTranslateLoader),
        deps: [HttpClient]
      },
    }),
    ToastrModule.forRoot(
      {
        timeOut: 1500,
        positionClass: 'toast-bottom-right',
        preventDuplicates: true,
      }
    ),
    EShareModule.forRoot(),
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [
    // {
    //   provide: HTTP_INTERCEPTORS,
    //   useClass: AuthInterceptor,
    //   multi: true
    // }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
