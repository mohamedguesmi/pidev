<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Commande
 *
 * @ORM\Table(name="commande")
 * @ORM\Entity
 */
class Commande
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
     *
     * @ORM\Column(name="nomlivre", type="string", length=255, nullable=false)
     */
    private $nomlivre;

    /**
     * @var int
     *
     * @ORM\Column(name="nbp", type="integer", nullable=false)
     */
    private $nbp;

    /**
     * @var string
     *
     * @ORM\Column(name="dateC", type="string", length=255, nullable=false)
     */
    private $datec;

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

    public function getNbp(): ?int
    {
        return $this->nbp;
    }

    public function setNbp(int $nbp): self
    {
        $this->nbp = $nbp;

        return $this;
    }

    public function getDatec(): ?string
    {
        return $this->datec;
    }

    public function setDatec(string $datec): self
    {
        $this->datec = $datec;

        return $this;
    }


}
