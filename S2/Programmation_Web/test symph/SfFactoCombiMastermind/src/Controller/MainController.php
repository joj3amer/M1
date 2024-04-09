<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;

function binomial($n,$p) {
    $result = 1;

    if ($p > $n-$p){
        $p = $n-$p;
    }

    for ($i=0; $i<$p; ++$i){
        $result *= ($n-$i);
        $result /= ($i+1);
    }
    return $result;
}

function fact(int $n){
    $results = 1;
    for($i = 1; $i <= $n; $i++){
        $results *= $i;
    }
    return $results;
}

class MainController extends AbstractController{

    #[Route('/', name: 'app_fact',methods:"GET")]
    public function index(Request $n): Response{

        $value = $n->query->get('fibonacci');
        $value1 = $n->query->get('n');
        $value2 = $n->query->get('p');
        $resultat = $value ? "Le résultat est ".fact($value) : ($value1 ? ($value2 ? "Le resultat est ".binomial($value1,$value2) : "Veuillez entrer une valeur") : "Veuillez entrer une valeur pour p !");

        return $this->render('main/index.html.twig', [
            'controller_name' => 'MainController',
            'value' => $resultat,
        ]);
    }
}
