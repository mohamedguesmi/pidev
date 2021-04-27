<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Service
 *
 * @ORM\Table(name="service")
 * @ORM\Entity
 */
class Service
{
    /**
     * @var int
     *
     * @ORM\Column(name="idS", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $ids;

    /**
     * @var string
     *
     * @ORM\Column(name="nomS", type="string", length=255, nullable=false)
     */
    private $noms;

    /**
     * @var string
     *
     * @ORM\Column(name="langueA", type="string", length=255, nullable=false)
     */
    private $languea;

    /**
     * @var string
     *
     * @ORM\Column(name="dateS", type="string", length=255, nullable=false)
     */
    private $dates;

    /**
     * @var string
     *
     * @ORM\Column(name="sujetR", type="string", length=255, nullable=false)
     */
    private $sujetr;

    /**
     * @var string
     *
     * @ORM\Column(name="user", type="string", length=255, nullable=false)
     */
    private $user;

    public function getIds(): ?int
    {
        return $this->ids;
    }

    public function getNoms(): ?string
    {
        return $this->noms;
    }

    public function setNoms(string $noms): self
    {
        $this->noms = $noms;

        return $this;
    }

    public function getLanguea(): ?string
    {
        return $this->languea;
    }

    public function setLanguea(string $languea): self
    {
        $this->languea = $languea;

        return $this;
    }

    public function getDates(): ?string
    {
        return $this->dates;
    }

    public function setDates(string $dates): self
    {
        $this->dates = $dates;

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

    public function getUser(): ?string
    {
        return $this->user;
    }

    public function setUser(string $user): self
    {
        $this->user = $user;

        return $this;
    }


}
