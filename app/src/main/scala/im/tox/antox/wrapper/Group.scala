package im.tox.antox.wrapper

import im.tox.antox.tox.ToxSingleton

class Group(val id: String,
            val groupNumber: Int,
            var name: String,
            var alias: String,
            var topic: String,
            val peers: PeerList) {


  def addPeer(tox: ToxCore, peerNumber: Int): Unit = {
    this.peers.addGroupPeer(new GroupPeer(tox.getGroupPeerName(groupNumber, peerNumber), ignored = false))
  }

  def getPeerCount: Int = {
    peers.all().size()
  }

  def leave(partMessage: String): Unit = {
    ToxSingleton.tox.deleteGroup(groupNumber, partMessage)
  }

  override def toString: String = name
}