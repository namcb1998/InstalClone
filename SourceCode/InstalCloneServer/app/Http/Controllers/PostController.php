<?php

namespace App\Http\Controllers;

use App\Post;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class PostController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $posts = Post::all();
        $jsonPost = json_decode(json_encode($posts), TRUE);
        $postsList = array();


        foreach ($jsonPost as $key => $value) {
            $idPost = json_decode(json_encode($value))->id;
            $comment = DB::table('comments')->where('id_post', $idPost)->get();
            $like = DB::table('likes')->where('id_post', $idPost)->get();
            array_push($postsList, [$value, "comments" => $comment, "likes" => $like]);
        }

        return response(json_encode($postsList), 201);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {

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
            $post = new Post();
            $post->id_user = $request->id_user;
            $encode_string = $request->encode_string;
            $image = base64_decode($encode_string);
            $link_image = "images/" . $request->id_user . time();
            file_put_contents($link_image, $image);
            $post->title = $request->title;
            $post->privacy = $request->privacy;
            $post->image_link = $link_image;
            $post->save();
            return response($post, 201);
        } catch (\Exception $exception) {
            return response(["message" => $exception->getMessage()], 400);
        }
    }

    public function getPostByUserID(Request $request)
    {
        $idUser = $request->id_user;
        $post = DB::table('posts')->where('id_user', $idUser)->get();
        $objectJsonPostArray = json_decode(json_encode($post));
        $postsList = array();


        foreach ($objectJsonPostArray as $key => $value) {
            $idPost = json_decode(json_encode($value))->id;
            $comment = DB::table('comments')->where('id_post', $idPost)->get();
            $like = DB::table('likes')->where('id_post', $idPost)->get();
            array_push($postsList, [$value, "comments" => $comment, "likes" => $like]);
        }
        return response($postsList, 201);
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
