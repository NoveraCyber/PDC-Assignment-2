package Q1_TradeEngine;

public class TradingEngineApp {
    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        TradeEvent genericEvent = new TradeEvent("CEP_ENGINE_00", now, 1500.00);
        TradeEvent fixEvent = new FIXOrderEvent("FIX_ADAPTER_01", now, 1500.00, "ORD-99823");
        TradeEvent reutersEvent = new ReutersQuoteEvent("REUTERS_QUOTE_02", now, 1500.00, 1499.50, 1501.25);

        System.out.println("--- CEP Engine Dispatching Market Events ---");
        genericEvent.dispatch();
        fixEvent.dispatch();
        reutersEvent.dispatch();
    }
}