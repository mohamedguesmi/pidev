<?php

namespace App\Controller;

use App\Entity\Attestation;
use App\Form\AttestationType;
use Dompdf\Dompdf;
use Dompdf\Options;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/attestation")
 */
class AttestationController extends AbstractController
{
    /**
     * @Route("/", name="attestation_index", methods={"GET"})
     */
    public function index(): Response
    {
        $attestations = $this->getDoctrine()
            ->getRepository(Attestation::class)
            ->findAll();

        return $this->render('attestation/index.html.twig', [
            'attestations' => $attestations,
        ]);
    }

    /**
     * @Route("/backk", name="attestation_indexback", methods={"GET"})
     */
    public function indexx(): Response
    {
        $attestations = $this->getDoctrine()
            ->getRepository(Attestation::class)
            ->findAll();

        return $this->render('attestation/indexb.html.twig', [
            'attestations' => $attestations,
        ]);
    }

    /**
     * @Route("/pdf", name="pdf", methods={"GET"})
     */
    public function pdf(): Response
    {

        // Configure Dompdf according to your needs
        $pdfOptions = new Options();
        $pdfOptions->set('defaultFont', 'Arial');

        // Instantiate Dompdf with our options
        $dompdf = new Dompdf($pdfOptions);
        $attestations = $this->getDoctrine()
            ->getRepository(Attestation::class)
            ->findAll();


        // Retrieve the HTML generated in our twig file
        $html = $this->renderView('attestation/pdf.html.twig', [
            'attestations' => $attestations,
        ]);

        // Load HTML to Dompdf
        $dompdf->loadHtml($html);

        // (Optional) Setup the paper size and orientation 'portrait' or 'portrait'
        $dompdf->setPaper('A4', 'portrait');

        // Render the HTML as PDF
        $dompdf->render();

        // Output the generated PDF to Browser (force download)
        $dompdf->stream("mypdf.pdf", [
            "Attachment" => true
        ]);

    }

    /**
     * @Route("/new", name="attestation_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $attestation = new Attestation();
        $form = $this->createForm(AttestationType::class, $attestation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($attestation);
            $entityManager->flush();

            return $this->redirectToRoute('attestation_index');
        }

        return $this->render('attestation/new.html.twig', [
            'attestation' => $attestation,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="attestation_show", methods={"GET"})
     */
    public function show(Attestation $attestation): Response
    {
        return $this->render('attestation/show.html.twig', [
            'attestation' => $attestation,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="attestation_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Attestation $attestation): Response
    {
        $form = $this->createForm(AttestationType::class, $attestation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('attestation_index');
        }

        return $this->render('attestation/edit.html.twig', [
            'attestation' => $attestation,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="attestation_delete", methods={"POST"})
     */
    public function delete(Request $request, Attestation $attestation): Response
    {
        if ($this->isCsrfTokenValid('delete'.$attestation->getId(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($attestation);
            $entityManager->flush();
        }

        return $this->redirectToRoute('attestation_index');
    }
}
