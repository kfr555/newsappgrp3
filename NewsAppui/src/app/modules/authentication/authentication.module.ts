import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import {SharedModule} from '../shared/shared.module'
import { RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms'
import {ReactiveFormsModule} from '@angular/forms';
import {AuthenticationService} from './authentication.service'
import {HttpClientModule} from '@angular/common/http';
import { AdminComponent } from './components/admin/admin.component';
import { HomeComponent } from './components/home/home.component';
const authRouter: Routes = [
  {
    path:'',
    children: [
      {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
      },
      {path:'home',component:HomeComponent},
      {
        path:'admin',component:AdminComponent
      },
      {
        path: 'register',
        component: RegisterComponent,
      },
      {
        path: 'login',
        component: LoginComponent,
      }
    ]
  }
];
@NgModule({
  declarations: [LoginComponent, RegisterComponent, AdminComponent, HomeComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(authRouter),
    SharedModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
    
  ],
  providers:[AuthenticationService],
  exports: [
    RouterModule,
    RegisterComponent,
    LoginComponent,
    SharedModule
  ]
})
export class AuthenticationModule { }
