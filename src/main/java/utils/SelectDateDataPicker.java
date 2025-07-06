package utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectDateDataPicker implements Task {
    private final String dateFrom, dateTo;
    private final Target dataPickerFrom, dataPickerTo;
    String dayFrom, monthFrom, yearFrom, dayTo, monthTo, yearTo;

    public SelectDateDataPicker(String dateFrom, String dateTo, Target dataPickerFrom, Target dataPickerTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.dataPickerFrom = dataPickerFrom;
        this.dataPickerTo = dataPickerTo;
    }

    public static Performable dateRange(String dateFrom, String dateTo, Target dataPickerFrom, Target dataPickerTo) {
        return instrumented(SelectDateDataPicker.class, dateFrom, dateTo, dataPickerFrom, dataPickerTo);
    }

    public void getDateRange (String dateFrom, String dateTo){
        String[] temp = dateFrom.split("/");
        dayFrom = temp[0];
        monthFrom = temp[1];
        yearFrom = temp[2];

        temp = dateTo.split("/");
        dayTo = temp[0];
        monthTo = temp[1];
        yearTo = temp[2];

        monthFrom = convertMonth(monthFrom);
        monthTo = convertMonth(monthTo);
    }

    public String convertMonth (String month)
    {
        switch (Integer.parseInt(month)){
            case 1:
                month = "Enero";
                break;

            case 2:
                month = "Febrero";
                break;

            case 3:
                month = "Marzo";
                break;

            case 4:
                month = "Abril";
                break;

            case 5:
                month = "Mayo";
                break;

            case 6:
                month = "Junio";
                break;

            case 7:
                month = "Julio";
                break;

            case 8:
                month = "Agosto";
                break;

            case 9:
                month = "Septiembre";
                break;

            case 10:
                month = "Octubre";
                break;

            case 11:
                month = "Noviembre";
                break;

            case 12:
                month = "Diciembre";
                break;
        }

        return month;
    }

    @Override
    public <T extends Actor> void performAs(T t) {

    }
    /*

    public <T extends Actor> void performAs(T actor) {
        LocalDate fechaActual = LocalDate.now();

        actor.attemptsTo(
                Scroll.to(dataPickerFrom),
                Click.on(dataPickerFrom),
                WaitUntil.the(TransactionInquiryView.PREVIOUS_ARROW_CALENDAR, isVisible()).forNoMoreThan(10).seconds()
        );

        getDateRange(dateFrom, dateTo);
        if (!TransactionInquiryView.TEXT_YEAR_CALENDAR.resolveFor(actor).getText().trim().equals(yearFrom)){
            if (Integer.parseInt(yearFrom) < fechaActual.getYear()){
                while (!TransactionInquiryView.TEXT_YEAR_CALENDAR.resolveFor(actor).getText().trim().equals(yearFrom)){
                    actor.attemptsTo(
                            Click.on(TransactionInquiryView.PREVIOUS_ARROW_CALENDAR)
                    );
                }
            }

            if (Integer.parseInt(yearFrom) > fechaActual.getYear()){
                while (!TransactionInquiryView.TEXT_YEAR_CALENDAR.resolveFor(actor).getText().trim().equals(yearFrom)){
                    actor.attemptsTo(
                            Click.on(TransactionInquiryView.NEXT_ARROW_CALENDAR)
                    );
                }
            }
        }

        if (!TransactionInquiryView.TEXT_MONTH_CALENDAR.resolveFor(actor).getText().trim().equals(monthFrom)){
            int backMonth = 0;

            while ((!TransactionInquiryView.TEXT_MONTH_CALENDAR.resolveFor(actor).getText().trim().equals("Diciembre")) && (backMonth < 12)) {
                actor.attemptsTo(
                        Click.on(TransactionInquiryView.NEXT_ARROW_CALENDAR)
                );

                backMonth++;
            }
        }

        while (!TransactionInquiryView.TEXT_MONTH_CALENDAR.resolveFor(actor).getText().trim().equals(monthFrom)){
            actor.attemptsTo(
                    Click.on(TransactionInquiryView.PREVIOUS_ARROW_CALENDAR)
            );
        }

        actor.attemptsTo(
                Click.on(By.id("ui-datepicker-div"), By.linkText(dayFrom)),
                Click.on(dataPickerTo),
                WaitUntil.the(TransactionInquiryView.PREVIOUS_ARROW_CALENDAR, isVisible()).forNoMoreThan(10).seconds()
        );

        if (!TransactionInquiryView.TEXT_YEAR_CALENDAR.resolveFor(actor).getText().trim().equals(yearTo)){
            if (Integer.parseInt(yearFrom) < fechaActual.getYear()){
                while (!TransactionInquiryView.TEXT_YEAR_CALENDAR.resolveFor(actor).getText().trim().equals(yearFrom)){
                    actor.attemptsTo(
                            Click.on(TransactionInquiryView.PREVIOUS_ARROW_CALENDAR)
                    );
                }
            }

            if (Integer.parseInt(yearFrom) > fechaActual.getYear()){
                while (!TransactionInquiryView.TEXT_YEAR_CALENDAR.resolveFor(actor).getText().trim().equals(yearFrom)){
                    actor.attemptsTo(
                            Click.on(TransactionInquiryView.NEXT_ARROW_CALENDAR)
                    );
                }
            }
        }

        if (!TransactionInquiryView.TEXT_MONTH_CALENDAR.resolveFor(actor).getText().trim().equals(monthTo)){
            int backMonth = 0;

            while ((!TransactionInquiryView.TEXT_MONTH_CALENDAR.resolveFor(actor).getText().trim().equals("Diciembre")) && (backMonth < 12)) {
                actor.attemptsTo(
                        Click.on(TransactionInquiryView.NEXT_ARROW_CALENDAR)
                );

                backMonth++;
            }
        }

        while (!TransactionInquiryView.TEXT_MONTH_CALENDAR.resolveFor(actor).getText().trim().equals(monthTo)){
            actor.attemptsTo(
                    Click.on(TransactionInquiryView.PREVIOUS_ARROW_CALENDAR)
            );
        }

        actor.attemptsTo(
                Click.on(By.id("ui-datepicker-div"), By.linkText(dayTo))
        );
    }

     */
}
