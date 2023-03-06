package org.p2p.solanaj.own;

import org.bitcoinj.core.Base58;
import org.junit.Test;
import org.p2p.solanaj.core.PublicKey;
import org.p2p.solanaj.rpc.RpcClient;
import org.p2p.solanaj.rpc.RpcException;

import java.util.Arrays;

public class OwnTryUsingTest {

    private static RpcClient rpcClient = new RpcClient("https://api.devnet.solana.com");
    private static PublicKey account = new PublicKey("AnayTW335MabjhtXTJeBit5jdLhNeUVBVPXeRKCid79D");

    @Test
    public void balanceRetrieving() throws RpcException {
        long balance = rpcClient.getApi().getBalance(account);
        System.out.println(balance);
    }

    @Test
    public void decodeCheck() {
        System.out.println(Base58.decodeChecked("AnayTW335MabjhtXTJeBit5jdLhNeUVBVPXeRKCid79D"));
    }

    @Test
    public void findTokenRelatedAddress() throws Exception {
        PublicKey.ProgramDerivedAddress derivedAddress = PublicKey.findProgramAddress(
                Arrays.asList(
                        new PublicKey("AnayTW335MabjhtXTJeBit5jdLhNeUVBVPXeRKCid79D").toByteArray(),
                        new PublicKey("TokenkegQfeZyiNwAJbNbGKPFXCWuBvf9Ss623VQ5DA").toByteArray(),
                        new PublicKey("Gh9ZwEmdLJ8DscKNTkTqPbNwLNNBjuSzaG9Vp2KGtKJr").toByteArray()),
                new PublicKey("ATokenGPvbdGVxr1b2hvZbsiqW5xWH25efTNsLJA8knL"));
        System.out.println(derivedAddress.getAddress());
    }

}
