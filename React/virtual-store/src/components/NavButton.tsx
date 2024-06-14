
export default function NavBar({ title, link }) {
  return (
    <>
      <li className="list-none">
        <a className="text-white font-bold text-center no-underline inline-block w-[150px] py-1 text-base hover:underline" href={link}>
          {title}
        </a>
      </li>
    </>
  );
}
