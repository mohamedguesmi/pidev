<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * ParticapationEvent
 *
 * @ORM\Table(name="particapation_event", indexes={@ORM\Index(name="fk_evenement", columns={"id_event"})})
 * @ORM\Entity
 */
class ParticapationEvent
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
     * @ORM\Column(name="id_event", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $idEvent;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getIdUser(): ?int
    {
        return $this->idUser;
    }

    public function getIdEvent(): ?int
    {
        return $this->idEvent;
    }


}
