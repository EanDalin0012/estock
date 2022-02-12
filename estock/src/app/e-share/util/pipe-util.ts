
export abstract class PipeUtil {

  constructor() {

  }

  public static amount(value: number) {
    return (value).toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&,');
  }

}
