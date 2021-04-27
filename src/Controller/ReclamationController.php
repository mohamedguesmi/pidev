<?php

namespace App\Controller;

use App\Entity\Reclamation;
use App\Form\ReclamationType;
use Knp\Component\Pager\PaginatorInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/reclamation")
 */
class ReclamationController extends AbstractController
{
    /**
     * @Route("/", name="reclamation_index", methods={"GET"})
     */
    public function index(Request $request,PaginatorInterface $paginator): Response
    {
        $donnee = $this->getDoctrine()
            ->getRepository(Reclamation::class)
            ->findAll();
        // Paginate the results of the query
        $reclamations = $paginator->paginate(
        // Doctrine Query, not results
            $donnee,
            // Define the page parameter
            $request->query->getInt('page', 1),
            // Items per page
            2
        );

        return $this->render('reclamation/index.html.twig', [
            'reclamations' => $reclamations,
        ]);
    }

    /**
     * @Route("/back", name="reclamation_indexback", methods={"GET"})
     */
    public function indexback(): Response
    {
        $reclamations = $this->getDoctrine()
            ->getRepository(Reclamation::class)
            ->findAll();

        return $this->render('reclamation/indexb.html.twig', [
            'reclamations' => $reclamations,
        ]);
    }

    /**
     * @Route("/new", name="reclamation_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $reclamation = new Reclamation();
        $form = $this->createForm(ReclamationType::class, $reclamation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($reclamation);
            $entityManager->flush();

            return $this->redirectToRoute('reclamation_index');
        }

        return $this->render('reclamation/new.html.twig', [
            'reclamation' => $reclamation,
            'form' => $form->createView(),
        ]);
    }
    /**
     * @Route("/reclamation/listASCreclamation", name="list_reclamationfrontASC")
     */
    public function Sortreclamationfront(Request $request)
    {
        $reclamation = $this->getDoctrine()->getRepository(Reclamation::class)->findBy(array(),array('nomr'=>'ASC'));

        return $this->render('reclamation/listeAsc.html.twig', [
            'reclamation' => $reclamation,
        ]);
    }
    /**
     * @Route("/reclamation/listDESCreclamation", name="list_reclamationfrontDESC")
     */
    public function SortreclamationfrontD(Request $request)
    {
        $reclamation = $this->getDoctrine()->getRepository(Reclamation::class)->findBy(array(),array('nomr'=>'DESC'));

        return $this->render('reclamation/listeDsc.html.twig', [
            'reclamation' => $reclamation,
        ]);
    }

    /**
     * @Route("/{idreclamation}", name="reclamation_show", methods={"GET"})
     */
    public function show(Reclamation $reclamation): Response
    {
        return $this->render('reclamation/show.html.twig', [
            'reclamation' => $reclamation,
        ]);
    }

    /**
     * @Route("/{idreclamation}/edit", name="reclamation_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Reclamation $reclamation): Response
    {
        $form = $this->createForm(ReclamationType::class, $reclamation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('reclamation_index');
        }

        return $this->render('reclamation/edit.html.twig', [
            'reclamation' => $reclamation,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idreclamation}", name="reclamation_delete", methods={"POST"})
     */
    public function delete(Request $request, Reclamation $reclamation): Response
    {
        if ($this->isCsrfTokenValid('delete'.$reclamation->getIdreclamation(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($reclamation);
            $entityManager->flush();
        }

        return $this->redirectToRoute('reclamation_index');
    }
    /**
     * @Route("/formation/recherche_formation", name="ajaxsearch")
     */
    public function searchAction(Request $request)
    {
        $em=$this->getDoctrine()->getManager();
        $requestString = $request->get('q');
        $reclamation = $em->getRepository(Reclamation::class)->findEntitiesByString($requestString);
        if(!$reclamation)
        {
            $result['reclamation']['error']="reclamation introuvable :( ";

        }else{
            $result['reclamation']=$this->getRealEntities($reclamation);
        }
        return new Response(json_encode($result));

    }
    public function getRealEntities($reclamation){
        foreach ($reclamation as $reclamation){
            $realEntities[$reclamation->getIdreclamation()] = [$reclamation->getNomr()];
        }
        return $realEntities;
    }
}
