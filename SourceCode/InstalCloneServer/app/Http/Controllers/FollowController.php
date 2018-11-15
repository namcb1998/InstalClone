<?php

namespace App\Http\Controllers;

use App\Follow;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class FollowController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //

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
        //
        $jsonFollow = array();
        $followed = DB::table('follows')
            ->where('id_user', $request->id_user)
            ->where('id_user_follow', $request->id_user_follow)
            ->first();
        if (isset($followed)) {
            array_push($jsonFollow, ["message" => "Cannot follow more than twice"]);
            return response($jsonFollow, 300);
        } else {
            $follow = new Follow();
            $follow->id_user = $request->id_user;
            $follow->id_user_follow = $request->id_user_follow;
            $follow->save();
            return response($follow, 201);
        }
    }

    public function unfollow(Request $request)
    {
        $jsonUnFollow = array();
        $query = DB::table('follows')
            ->where('id_user', $request->id_user)
            ->where('id_user_follow', $request->id_user_follow);

        $followed = $query->first();

        if (isset($followed)) {
            $query->delete();
            array_push($jsonUnFollow, ["message" => "Success"]);
            return response($jsonUnFollow, 201);
        } else {
            array_push($jsonUnFollow, ["message" => "Unfollow already"]);
            return response($jsonUnFollow, 300);
        }
    }

    /**
     * Display the specified resource.
     *
     * @param  int $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
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
        echo "delete";
    }
}
