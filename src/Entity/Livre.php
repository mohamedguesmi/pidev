<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * Livre
 *
 * @ORM\Table(name="livre")
 * @ORM\Entity
 */
class Livre
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     * @Assert\NotBlank
     * @ORM\Column(name="nomlivre", type="string", length=255, nullable=false)
     */
    private $nomlivre;

    /**
     * @var string
     * @Assert\NotBlank
     * @ORM\Column(name="auteurlivre", type="string", length=255, nullable=false)
     */
    private $auteurlivre;

    /**
     * @var int
     * @Assert\NotBlank
     * @Assert\Positive
     * @ORM\Column(name="prixlivre", type="integer", nullable=false)
     */
    private $prixlivre;

    /**
     * @var string
     * @Assert\NotBlank
     * @ORM\Column(name="contenu", type="string", length=255, nullable=false)
     */
    private $contenu;

    /**
     * @var int
     * @Assert\NotBlank
     * @Assert\Positive
     * @ORM\Column(name="quantitelivre", type="integer", nullable=false)
     */
    private $quantitelivre;

    /**
     * @var string
     * @Assert\NotBlank
     * @ORM\Column(name="imageLivre", type="string", length=255, nullable=false)
     */
    private $imagelivre;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNomlivre(): ?string
    {
        return $this->nomlivre;
    }

    public function setNomlivre(string $nomlivre): self
    {
        $this->nomlivre = $nomlivre;

        return $this;
    }

    public function getAuteurlivre(): ?string
    {
        return $this->auteurlivre;
    }

    public function setAuteurlivre(string $auteurlivre): self
    {
        $this->auteurlivre = $auteurlivre;

        return $this;
    }

    public function getPrixlivre(): ?int
    {
        return $this->prixlivre;
    }

    public function setPrixlivre(int $prixlivre): self
    {
        $this->prixlivre = $prixlivre;

        return $this;
    }

    public function getContenu(): ?string
    {
        return $this->contenu;
    }

    public function setContenu(string $contenu): self
    {
        $this->contenu = $contenu;

        return $this;
    }

    public function getQuantitelivre(): ?int
    {
        return $this->quantitelivre;
    }

    public function setQuantitelivre(int $quantitelivre): self
    {
        $this->quantitelivre = $quantitelivre;

        return $this;
    }

    public function getImagelivre(): ?string
    {
        return $this->imagelivre;
    }

    public function setImagelivre(string $imagelivre): self
    {
        $this->imagelivre = $imagelivre;

        return $this;
    }


}
