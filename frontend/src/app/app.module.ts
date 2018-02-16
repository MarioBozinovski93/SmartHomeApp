import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { HttpModule } from '@angular/http';
import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { LoginPage } from '../pages/login/login';
import { StatusPage } from '../pages/status/status';
import { ApiProvider } from '../providers/api-provider/api-provider';
import { globalVar } from '../providers/global-var/globar-var';
import { UserPage } from '../pages/CreateUser/createuser';
import { AlertController } from 'ionic-angular/components/alert/alert-controller';


@NgModule({
  declarations: [
    MyApp,
    HomePage,
    LoginPage,
    StatusPage,
    UserPage
  ],
  imports: [
    BrowserModule,
    HttpModule,
    IonicModule.forRoot(MyApp)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    LoginPage,
    StatusPage,
    UserPage
  ],
  providers: [
    ApiProvider,
    globalVar,
    StatusBar,
    SplashScreen,
    AlertController,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
