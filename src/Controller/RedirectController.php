<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class RedirectController extends AbstractController
{
    /**
     * @Route("/redirect", name="redirect")
     */
    public function index(): Response
    {
        return $this->render('redirect/index.html.twig', [
            'controller_name' => 'RedirectController',
        ]);
    }

    /**
     * @Route("/backend", name="backend")
     */
    public function backend(): Response
    {
        return $this->render('backend/backend.html.twig', [
            'controller_name' => 'RedirectController',
        ]);
    }

    /**
     * @Route("/frontend", name="frontend")
     */
    public function frontend(): Response
    {
        return $this->render('frontend/frontheaderfooter.html.twig', [
            'controller_name' => 'RedirectController',
        ]);
    }
}

