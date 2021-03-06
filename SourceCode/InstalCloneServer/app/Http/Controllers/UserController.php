<?php

namespace App\Http\Controllers;

use App\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;


class UserController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $users = User::all();
        echo "$users";
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        try {
            $user = new User();
            $user->display_name = $request->username;
            $user->username = $request->username;
            $user->link_avatar = "https://www.fancyhands.com/images/default-avatar-250x250.png";
            $user->role = 1;
            $user->gender = true;
            $user->birthday = 946684800000;
            $user->password = $request->password;
            $user->save();
            return response($user, 201);
        } catch (\Exception $exception) {
            return response(["message" => $exception->getMessage()], 400);
        }

    }


    public function login(Request $request)
    {
        $jsonLogin = array();
        $username = $request->username;
        $password = $request->password;
        $user = DB::table('users')->where('username', $username)->where('password', $password)->first();
        if (isset($user)) {
            return response(json_encode($user), 201);
        } else {
            array_push($jsonLogin, ["message" => "Incorrect username or password"]);
            return response($jsonLogin, 300);
        }
    }

    public function updateUser(Request $request)
    {
        $display_name = $request->display_name;
        $email = $request->email;
        $gender = $request->gender;
        $birthday = $request->birthday;
        $password = $request->password;
        $encode_string = $request->encode_string;

        $id = $request->id;
        $user = User::find($id);
        if (isset($display_name)) {
            $user->display_name = $display_name;
        }
        if (isset($email)) {
            $user->email = $email;
        }
        if (isset($gender)) {
            $user->gender = $gender;
        }
        if (isset($birthday)) {
            $user->birthday = $birthday;
        }
        if (isset($password)) {
            $user->password = $password;
        }
        if (isset($encode_string)) {
            $image = base64_decode($encode_string);
            $link_image = "avatars/" . $request->id_user . time();
            file_put_contents($link_image, $image);
            $user->link_avatar = $link_image;
        }

        $user->save();

        return response($user, 201);
    }

    public function getUser(Request $request)
    {
        $stringArrayID = $request->list_id;
        $arrayID = json_decode($stringArrayID);
        $arrayUsers = array();
        foreach ($arrayID as $key => $value) {
            $user = User::find($value);
            array_push($arrayUsers, $user);
        }
        return response($arrayUsers, 201);
    }

    /**
     * Display the specified resource.
     *
     * @param  int $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {

    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request $request
     * @param  int $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
    }
}
