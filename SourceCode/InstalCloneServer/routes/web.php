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

Route::post('User/updateUser', 'UserController@updateUser');

Route::post('User/getUser', 'UserController@getUser');

Route::resource('Post', 'PostController');

Route::post('Post/getbyuserid', 'PostController@getPostByUserID');

Route::resource('Comment', 'CommentController');

Route::resource('Follow', 'FollowController');

Route::post('Follow/unfollow', 'FollowController@unfollow');

Route::resource('Like', 'LikeController');

Route::post('Like/unlike', 'LikeController@unlike');


