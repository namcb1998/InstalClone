<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('signup', function () {
    echo 'test sdsad';
});

Route::resource('User', 'UserController');

Route::post('User/login', 'UserController@login');

Route::resource('Post', 'PostController');

Route::post('Post/getbyuserid', 'PostController@getPostByUserID');



