export default function Hero({first,second}) {
  return (
    <>
      <section className="h-52 bg-[url('/hero_bg.png')] bg-cover bg-top-center flex justify-center">
        <article className="w-[1080px] flex flex-col items-start justify-center px-5">
          <span className="text-white font-bold text-xl">{first}</span>
          <span className="text-white font-bold text-[50px] leading-7">{second}</span>
        </article>
      </section>
    </>
  );
}
