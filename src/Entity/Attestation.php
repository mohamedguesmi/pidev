<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * Attestation
 *
 * @ORM\Table(name="attestation")
 * @ORM\Entity
 */
class Attestation
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
     * @ORM\Column(name="typeA", type="string", length=255, nullable=false)
     */
    private $typea;

    /**
     * @var string
     * @Assert\NotBlank
     * @ORM\Column(name="langueA", type="string", length=255, nullable=false)
     */
    private $languea;

    /**
     * @var string
     * @Assert\NotBlank
     * @ORM\Column(name="dateA", type="string", length=255, nullable=false)
     */
    private $datea;

    /**
     * @var int
     * @Assert\NotBlank
     * @ORM\Column(name="user", type="integer", nullable=false)
     */
    private $user;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getTypea(): ?string
    {
        return $this->typea;
    }

    public function setTypea(string $typea): self
    {
        $this->typea = $typea;

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

    public function getDatea(): ?string
    {
        return $this->datea;
    }

    public function setDatea(string $datea): self
    {
        $this->datea = $datea;

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
