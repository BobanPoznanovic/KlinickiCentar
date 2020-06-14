export class Pregled {
    pregledID : number;
    kategorija_pregleda : string;
    lekarID : number;
    pacijentID : number;
    salaID : number;
    datum_pregleda : string;
    satnica_pocetak : string;
    satnica_kraj : string;
    tip_pregledaID : number;
    popust : number;
    zakazan_dodatan_pregled : boolean;
    zakazana_operacija : boolean;
    potvrdjen : boolean;
    zavrsen : boolean;
    lekar_ocenjen : boolean;
    klinika_ocenjena : boolean;
    lekarRating: number;
    klinikaRating: number;
}
