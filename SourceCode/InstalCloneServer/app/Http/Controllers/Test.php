<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class Test extends Controller
{
    public function hello()
    {
        /*return response()->json([
            'success' => true
        ], 200);*/
        echo phpinfo();
    }
}
