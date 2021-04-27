<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Reclamation
 *
 * @ORM\Table(name="reclamation")
 * @ORM\Entity(repositoryClass="App\Repository\ReaclamtionRepository")
 */
class Reclamation
{
    /**
     * @var int
     *
     * @ORM\Column(name="idReclamation", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idreclamation;

    /**
     * @var string
     *
     * @ORM\Column(name="nomR", type="string", length=255, nullable=false)
     */
    private $nomr;

    /**
     * @var string
     *
     * @ORM\Column(name="sujetR", type="string", length=255, nullable=false)
     */
    private $sujetr;

    /**
     * @var string
     *
     * @ORM\Column(name="dateR", type="string", length=255, nullable=false)
     */
    private $dater;

    /**
     * @var int
     *
     * @ORM\Column(name="user", type="integer", nullable=false)
     */
    private $user;

    public function getIdreclamation(): ?int
    {
        return $this->idreclamation;
    }

    public function getNomr(): ?string
    {
        return $this->nomr;
    }

    public function setNomr(string $nomr): self
    {
        $this->nomr = $nomr;

        return $this;
    }

    public function getSujetr(): ?string
    {
        return $this->sujetr;
    }

    public function setSujetr(string $sujetr): self
    {
        $this->sujetr = $sujetr;

        return $this;
    }

    public function getDater(): ?string
    {
        return $this->dater;
    }

    public function setDater(string $dater): self
    {
        $this->dater = $dater;

        return $this;
    }

    public function getUser(): ?int
    {
        return $this->user;
    }

    public function setUser(int $user): self
    {
        $this->user = $user;

        return $this;
    }


}
