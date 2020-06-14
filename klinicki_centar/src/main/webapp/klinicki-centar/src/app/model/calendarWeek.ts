import { CalendarEvent } from './calendarEvent';

export class CalendarWeek {
    sunday : CalendarEvent[];
    monday : CalendarEvent[];
    tuesday : CalendarEvent[];
    wednesday : CalendarEvent[];
    thursday : CalendarEvent[];
    friday : CalendarEvent[];
    saturday : CalendarEvent[];
    firstWeekInMonth : boolean;
    lastWeekInMonth : boolean;
    month : number;
    year : number;
    datumi : string[];
}