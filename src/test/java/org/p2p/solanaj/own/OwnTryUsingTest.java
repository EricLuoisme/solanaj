package org.p2p.solanaj.own;

import org.junit.Test;
import org.p2p.solanaj.core.PublicKey;
import org.p2p.solanaj.rpc.RpcClient;
import org.p2p.solanaj.rpc.RpcException;
import org.p2p.solanaj.rpc.types.AccountInfo;

import java.util.Arrays;

public class OwnTryUsingTest {

    private static RpcClient rpcClient = new RpcClient("https://solana-devnet.g.alchemy.com/v2/On35d8LdFc1QGYD-wCporecGj359qian");
    private static PublicKey account = new PublicKey("AnayTW335MabjhtXTJeBit5jdLhNeUVBVPXeRKCid79D");

    @Test
    public void balanceRetrieving() throws RpcException {
        long balance = rpcClient.getApi().getBalance(account);
        System.out.println(balance);
    }

    @Test
    public void findTokenRelatedAddress() throws Exception {
        PublicKey.ProgramDerivedAddress derivedAddress = PublicKey.findProgramAddress(
                Arrays.asList(
                        account.toByteArray(),
                        new PublicKey("TokenkegQfeZyiNwAJbNbGKPFXCWuBvf9Ss623VQ5DA").toByteArray(),
                        new PublicKey("Gh9ZwEmdLJ8DscKNTkTqPbNwLNNBjuSzaG9Vp2KGtKJr").toByteArray()),
                new PublicKey("ATokenGPvbdGVxr1b2hvZbsiqW5xWH25efTNsLJA8knL"));
        System.out.println(derivedAddress.getAddress());
    }

    @Test
    public void findTokenBalanceByOwner() throws RpcException {
        AccountInfo accountInfo = rpcClient.getApi().getAccountInfo(new PublicKey("Gd8nxWzbnJ2zwtn5TukvEMKKjjbFhdtqA1L67DgnRvXc"));
        System.out.println(accountInfo.toString());
    }

}
