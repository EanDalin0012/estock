import { SaleProductType } from "./sale-product-type";

export interface SaleProductTypeDetail {
  productId: number;
  productName: string;
  desc: string;
  saleProductTypes: SaleProductType[];
}
