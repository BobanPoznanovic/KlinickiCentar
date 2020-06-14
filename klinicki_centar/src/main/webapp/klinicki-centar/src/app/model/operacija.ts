export class Operacija {
  operacijaID: number;
  lekarID: number;
  datum_operacije: Date;
  satnica_pocetka_operacije: string;
  satnica_kraja_operacije: string;
  salaID: number;
  pacijentID: number;
  lekar_ocenjen: boolean;
  klinika_ocenjena: boolean;

  // mozda i ovo ?
  lekarRating: number;
  klinikaRating: number;
}
