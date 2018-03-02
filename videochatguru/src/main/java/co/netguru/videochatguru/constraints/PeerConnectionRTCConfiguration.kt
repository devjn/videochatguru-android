package co.netguru.videochatguru.constraints

import org.webrtc.PeerConnection


/**
 * Created by @author Jahongir on 02-Mar-18
 * devjn@jn-arts.com
 * PeerConnectionRTCConfiguration
 */
object PeerConnectionRTCConfiguration {

    fun getDafault(iceServers: List<PeerConnection.IceServer>? = null) = PeerConnection.RTCConfiguration(iceServers).apply {
        enableDtlsSrtp = true
        enableRtpDataChannel = false
        enableDscp = false
        disableIpv6 = false
        suspendBelowMinBitrate = false
        combinedAudioVideoBwe = false
        enableCpuOveruseDetection = true

        keyType = PeerConnection.KeyType.ECDSA;
        continualGatheringPolicy = PeerConnection.ContinualGatheringPolicy.GATHER_CONTINUALLY;
    }

}