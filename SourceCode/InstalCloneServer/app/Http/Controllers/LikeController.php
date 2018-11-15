<?php

namespace App\Http\Controllers;

use App\Like;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class LikeController extends Controller
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
        $jsonLike = array();
        $liked = DB::table('likes')
            ->where('id_owner', $request->id_user_owner)
            ->where('id_post', $request->id_post)
            ->first();
        if (isset($liked)) {
            array_push($jsonLike, ["message" => "Cannot Like more than twice"]);
            return response($jsonLike, 300);
        } else {
            $like = new Like();
            $like->id_owner = $request->id_user_owner;
            $like->id_post = $request->id_post;
            $like->save();
            return response($like, 201);
        }
    }

    public function unlike(Request $request)
    {
        $jsonUnLike = array();
        $query = DB::table('likes')
            ->where('id_owner', $request->id_user_owner)
            ->where('id_post', $request->id_post);
        $liked = $query->first();
        if (isset($liked)) {
            $query->delete();
            array_push($jsonUnLike, ["message" => "Success"]);
            return response($jsonUnLike, 201);
        } else {
            array_push($jsonUnLike, ["message" => "Not liked yet"]);
            return response($jsonUnLike, 300);
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
    }
}
