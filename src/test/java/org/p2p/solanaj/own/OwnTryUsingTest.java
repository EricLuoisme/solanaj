package org.p2p.solanaj.own;

import org.junit.Test;
import org.p2p.solanaj.core.PublicKey;
import org.p2p.solanaj.rpc.RpcClient;
import org.p2p.solanaj.rpc.RpcException;

public class OwnTryUsingTest {

    private static RpcClient rpcClient = new RpcClient("https://api.devnet.solana.com");
    private static PublicKey account = new PublicKey("AnayTW335MabjhtXTJeBit5jdLhNeUVBVPXeRKCid79D");

    @Test
    public void balanceRetrieving() throws RpcException {
        long balance = rpcClient.getApi().getBalance(account);
        System.out.println(balance);
    }

}
