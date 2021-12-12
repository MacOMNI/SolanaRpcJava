package com.solana;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import java.util.*;
import org.p2p.solanaj.core.PublicKey;
import org.p2p.solanaj.rpc.Cluster;
import org.p2p.solanaj.rpc.RpcApi;
import org.p2p.solanaj.rpc.RpcClient;
import org.p2p.solanaj.rpc.RpcException;
import org.p2p.solanaj.rpc.types.Block;
import org.p2p.solanaj.rpc.types.ConfirmedBlock;
import org.p2p.solanaj.rpc.types.EpochInfo;
import org.p2p.solanaj.rpc.types.config.Commitment;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test(expected = RpcException.class)
    public void TestApi()
    {
        PublicKey fromPublicKey = new PublicKey("QqCCvshxtqMAL2CVALqiJB7uEeE5mjSPsseQdDzsRUo");
        PublicKey toPublickKey = new PublicKey("GrDMoeqMLFjeXQ24H56S1RLgT4R76jsuWCd6SvXyGPQ5");
        RpcClient client = new RpcClient(Cluster.MAINNET);
        // ConfirmedBlock block;
        try {
           EpochInfo info = client.getApi().getEpochInfo();
            System.out.println(info);
            long slot = client.getApi().getSlot();
            System.out.println(slot);
            
            // block = client.getApi().getConfirmedBlock((int) slot);
            // System.out.println(block);
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("commitment", Commitment.CONFIRMED);
            Block  newBlock = client.getApi().getBlock((int) slot, params);
            System.out.println(newBlock);

        } catch (Exception e) {
            System.out.println(e);
            fail("Reason");

            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Hello world!");

    }
}
