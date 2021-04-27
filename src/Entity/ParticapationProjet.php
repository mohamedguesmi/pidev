<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * ParticapationProjet
 *
 * @ORM\Table(name="particapation_projet", indexes={@ORM\Index(name="fk_idprojet", columns={"id_projet"})})
 * @ORM\Entity
 */
class ParticapationProjet
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $id;

    /**
     * @var int
     *
     * @ORM\Column(name="id_user", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $idUser;

    /**
     * @var int
     *
     * @ORM\Column(name="id_projet", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $idProjet;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getIdUser(): ?int
    {
        return $this->idUser;
    }

    public function getIdProjet(): ?int
    {
        return $this->idProjet;
    }


}
