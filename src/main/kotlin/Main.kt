import repository.MemberRepository
import repository.MemberRepositoryImpl

fun main(args: Array<String>) {
    val memberRepository:MemberRepository = MemberRepositoryImpl()
    memberRepository.save()
    println(memberRepository.find())
}