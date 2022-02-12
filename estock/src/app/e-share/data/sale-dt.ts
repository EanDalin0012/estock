import { Proudct } from "./product";
import { SaleProductType } from "./sale-product-type";

export interface SaleDetail {
  saleProductType: SaleProductType;
  saleTypeProduct: string;
  proudct: Proudct;
  productName: string;
  price: string;
  newQty: number;
  totalQty: number;
  total: number;
  totalStr: string;
}
